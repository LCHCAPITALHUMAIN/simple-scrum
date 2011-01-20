package com.nazir.customscrum.server;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: N_Khan
 * Date: 20-Jan-2011
 * Time: 11:57:53
 * To change this template use File | Settings | File Templates.
 */
public class CustomScrumNamingStrategy extends DefaultNamingStrategy {
    private static final String PREFIX = "SCRUM_";

    @Override
    public String classToTableName(String className) {
        return PREFIX + super.classToTableName(className);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String tableName(String tableName) {
        return PREFIX + super.tableName(tableName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {
        return PREFIX + super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName) {
        return PREFIX + super.logicalCollectionTableName(tableName, ownerEntityTable, associatedEntityTable, propertyName);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
