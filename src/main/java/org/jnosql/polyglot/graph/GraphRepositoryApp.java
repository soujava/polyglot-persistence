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

public class GraphRepositoryApp {
    public static void main(String[] args) {

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

            God apollo = template.getTraversalVertex()
                    .hasLabel(God.class)
                    .has("name", "Apollo")
                    .<God>next()
                    .orElseGet(() ->
                            template.insert(new God(null, "Apollo", "Sun")));

            God zeus = template.getTraversalVertex()
                    .hasLabel(God.class)
                    .has("name", "Zeus")
                    .<God>next()
                    .orElseGet(() ->
                            template.insert(new God(null, "Zeus", "Thunder")));

            template.edge(diana, "brother", apollo);
            template.edge(apollo, "brother", diana);
            template.edge(zeus, "father", apollo);
            template.edge(zeus, "father", diana);

            template.delete(diana.getId());
            template.delete(zeus.getId());
            template.delete(apollo.getId());
        }
        System.exit(0);
    }
}
