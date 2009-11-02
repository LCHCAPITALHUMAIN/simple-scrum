package com.simplescrum.model



/**
 * Authority domain class.
 */
class AccessRole {

	static hasMany = [people: User]

	/** description */
	String description
	/** ROLE String */
	String authority

	static constraints = {
		authority(blank: false, unique: true)
		description()
	}
}
