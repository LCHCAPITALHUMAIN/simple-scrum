

package com.simplescrum.model

class ProductController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ productInstanceList: Product.list( params ), productInstanceTotal: Product.count() ]
    }

    def show = {
        def productInstance = Product.get( params.id )

        if(!productInstance) {
            flash.message = "Product not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ productInstance : productInstance ] }
    }

    def delete = {
        def productInstance = Product.get( params.id )
        if(productInstance) {
            try {
                productInstance.delete(flush:true)
                flash.message = "Product ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Product ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Product not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def productInstance = Product.get( params.id )

        if(!productInstance) {
            flash.message = "Product not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ productInstance : productInstance ]
        }
    }

    def update = {
        def productInstance = Product.get( params.id )
        if(productInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(productInstance.version > version) {
                    
                    productInstance.errors.rejectValue("version", "product.optimistic.locking.failure", "Another user has updated this Product while you were editing.")
                    render(view:'edit',model:[productInstance:productInstance])
                    return
                }
            }
            productInstance.properties = params
            if(!productInstance.hasErrors() && productInstance.save()) {
                flash.message = "Product ${params.id} updated"
                redirect(action:show,id:productInstance.id)
            }
            else {
                render(view:'edit',model:[productInstance:productInstance])
            }
        }
        else {
            flash.message = "Product not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def productInstance = new Product()
        productInstance.properties = params
        return ['productInstance':productInstance]
    }

    def save = {
        def productInstance = new Product(params)
        if(!productInstance.hasErrors() && productInstance.save()) {
            flash.message = "Product ${productInstance.id} created"
            redirect(action:show,id:productInstance.id)
        }
        else {
            render(view:'create',model:[productInstance:productInstance])
        }
    }
}
