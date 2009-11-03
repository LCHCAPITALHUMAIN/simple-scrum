

package com.simplescrum.model

class TeamCompositionController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ teamCompositionInstanceList: TeamComposition.list( params ), teamCompositionInstanceTotal: TeamComposition.count() ]
    }

    def show = {
        def teamCompositionInstance = TeamComposition.get( params.id )

        if(!teamCompositionInstance) {
            flash.message = "TeamComposition not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ teamCompositionInstance : teamCompositionInstance ] }
    }

    def delete = {
        def teamCompositionInstance = TeamComposition.get( params.id )
        if(teamCompositionInstance) {
            try {
                teamCompositionInstance.delete(flush:true)
                flash.message = "TeamComposition ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "TeamComposition ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "TeamComposition not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def teamCompositionInstance = TeamComposition.get( params.id )

        if(!teamCompositionInstance) {
            flash.message = "TeamComposition not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ teamCompositionInstance : teamCompositionInstance ]
        }
    }

    def update = {
        def teamCompositionInstance = TeamComposition.get( params.id )
        if(teamCompositionInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(teamCompositionInstance.version > version) {
                    
                    teamCompositionInstance.errors.rejectValue("version", "teamComposition.optimistic.locking.failure", "Another user has updated this TeamComposition while you were editing.")
                    render(view:'edit',model:[teamCompositionInstance:teamCompositionInstance])
                    return
                }
            }
            teamCompositionInstance.properties = params
            if(!teamCompositionInstance.hasErrors() && teamCompositionInstance.save()) {
                flash.message = "TeamComposition ${params.id} updated"
                redirect(action:show,id:teamCompositionInstance.id)
            }
            else {
                render(view:'edit',model:[teamCompositionInstance:teamCompositionInstance])
            }
        }
        else {
            flash.message = "TeamComposition not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def teamCompositionInstance = new TeamComposition()
        teamCompositionInstance.properties = params
        return ['teamCompositionInstance':teamCompositionInstance]
    }

    def save = {
        def teamCompositionInstance = new TeamComposition(params)
        if(!teamCompositionInstance.hasErrors() && teamCompositionInstance.save()) {
            flash.message = "TeamComposition ${teamCompositionInstance.id} created"
            redirect(action:show,id:teamCompositionInstance.id)
        }
        else {
            render(view:'create',model:[teamCompositionInstance:teamCompositionInstance])
        }
    }
}
