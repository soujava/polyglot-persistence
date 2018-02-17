/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package org.jnosql.polyglot.column;

import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class ColumnManagerProducer {

    private static final String HEROES = "goods";

    @Inject
    @ConfigurationUnit(name = "column")
    private ColumnFamilyManagerFactory<ColumnFamilyManager> managerFactory;

    @Produces
    public ColumnFamilyManager getManager() {
        return managerFactory.get(HEROES);
    }
}
