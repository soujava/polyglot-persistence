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

package org.jnosql.polyglot.graph;


import org.eclipse.jnosql.mapping.graph.GraphTemplate;
import org.jnosql.polyglot.God;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;

public class GraphTemplateApp {
    public static void main(String[] args)  {

        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {

            GraphTemplate template =
                    container.select(GraphTemplate.class)
                            .get();

            God diana = template.getTraversalVertex()
                    .hasLabel(God.class)
                    .has("name", "Diana")
                    .<God>next()
                    .orElseGet(() ->
                            template.insert(new God(null, "Diana", "Hunt")));

            System.out.println("query : " + diana);

            template.delete(diana.getId());

            Optional<God> god = template.getTraversalVertex(diana.getId()).next();

            System.out.println("Query: " + god);
        }
        System.exit(0);
    }
}

