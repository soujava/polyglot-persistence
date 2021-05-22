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
 * Otavio Santana (@otaviojava)
 * Carlos Santos (@carlosepdsJava)
 */

package org.jnosql.polyglot.column;


import jakarta.nosql.column.ColumnFamilyManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class ColumnManagerProducer {

    @Inject
    @ConfigProperty(defaultValue = "column") //switch to NoSQL that is configured in microprofile-config.properties
    private ColumnFamilyManager manager;

    @Produces
    public ColumnFamilyManager getManagerCassandra() {
        return manager;
    }

    public void destroy(@Disposes ColumnFamilyManager manager) {
        manager.close();
    }
}
