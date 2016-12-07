package com.anna.lure.hibernateexamples;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * The PhysicalNamingStrategy will be applied regardless of whether the attribute explicitly specified the column name or whether we determined that implicitly.
 */
public class MyPhysicalNamingStrategy implements PhysicalNamingStrategy{

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        // Naming standards do not apply to catalog names
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        // get sequence name in lower case
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(identifier.getText().toLowerCase(),
                identifier.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }
}
