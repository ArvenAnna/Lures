package com.anna.lure.hibernateexamples;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitAnyDiscriminatorColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitAnyKeyColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitCollectionTableNameSource;
import org.hibernate.boot.model.naming.ImplicitDiscriminatorColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.model.naming.ImplicitIdentifierColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitIndexColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitIndexNameSource;
import org.hibernate.boot.model.naming.ImplicitJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitJoinTableNameSource;
import org.hibernate.boot.model.naming.ImplicitMapKeyColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitTenantIdColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;

/**
 * The ImplicitNamingStrategy would only be applied if an explicit name was not given.
 */
public class MyNamingStrategy implements ImplicitNamingStrategy{
    @Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource implicitEntityNameSource) {
        String entityName = implicitEntityNameSource.getEntityNaming().getJpaEntityName();
        return new Identifier(entityName.toUpperCase(), true);
    }

    @Override
    public Identifier determineJoinTableName(ImplicitJoinTableNameSource implicitJoinTableNameSource) {
        return null;
    }

    @Override
    public Identifier determineCollectionTableName(ImplicitCollectionTableNameSource implicitCollectionTableNameSource) {
        return null;
    }

    @Override
    public Identifier determineDiscriminatorColumnName(ImplicitDiscriminatorColumnNameSource implicitDiscriminatorColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineTenantIdColumnName(ImplicitTenantIdColumnNameSource implicitTenantIdColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineIdentifierColumnName(ImplicitIdentifierColumnNameSource implicitIdentifierColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource implicitBasicColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource implicitJoinColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determinePrimaryKeyJoinColumnName(ImplicitPrimaryKeyJoinColumnNameSource implicitPrimaryKeyJoinColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineAnyDiscriminatorColumnName(ImplicitAnyDiscriminatorColumnNameSource implicitAnyDiscriminatorColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineAnyKeyColumnName(ImplicitAnyKeyColumnNameSource implicitAnyKeyColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineMapKeyColumnName(ImplicitMapKeyColumnNameSource implicitMapKeyColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineListIndexColumnName(ImplicitIndexColumnNameSource implicitIndexColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource implicitForeignKeyNameSource) {
        return null;
    }

    @Override
    public Identifier determineUniqueKeyName(ImplicitUniqueKeyNameSource implicitUniqueKeyNameSource) {
        return null;
    }

    @Override
    public Identifier determineIndexName(ImplicitIndexNameSource implicitIndexNameSource) {
        return null;
    }
}
