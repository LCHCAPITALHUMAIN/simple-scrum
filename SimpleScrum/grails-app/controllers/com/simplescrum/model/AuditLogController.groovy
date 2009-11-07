package com.simplescrum.model

import com.simplescrum.model.AuditLog

class AuditLogController {

  def index = { redirect(action: list, params: params) }

  // the delete, save and update actions only accept POST requests
  static allowedMethods = [delete: 'POST', save: 'POST', update: 'POST', query: ['POST','GET']]

  def list = {
    if (!params.max) params.max = 10
    [auditLogEventList: AuditLog.list(params)]
  }

  def query = {
    def auditLogEvent = new AuditLog();
    auditLogEvent.properties = params.auditLogEvent
    [auditParams: auditLogEvent, auditList: AuditLog.findAll(auditLogEvent,params)]
  }

  def show = {
    def auditLogEvent = AuditLog.get(params.id)

    if (!auditLogEvent) {
      flash.message = "AuditLogEvent not found with id ${params.id}"
      redirect(action: list)
    }
    else { return [auditLogEvent: auditLogEvent] }
  }

}