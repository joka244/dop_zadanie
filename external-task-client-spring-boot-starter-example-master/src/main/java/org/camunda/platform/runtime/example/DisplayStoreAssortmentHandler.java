/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.platform.runtime.example;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.soap1.StoreClient;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.soap1.StoreClient.getWSDLURL;

@Component
@ExternalTaskSubscription("show-assortment") // create a subscription for this topic name
public class DisplayStoreAssortmentHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String CLOTHES_TYPE = "Winter clothes";
        int QUANTITY_RESERVE = 1;

        Logger.getLogger("show-assortment").
                log(Level.INFO, "Stage show-assortment");

        URL url = getWSDLURL("http://localhost:8081/StoreSvcWeb/displayassortment?wsdl");
        StoreClient storeClient = new StoreClient();
        storeClient.process(url);

        VariableMap variables = Variables.createVariables();
        variables.put("clothesModel", CLOTHES_TYPE);
        variables.put("quantityReserve", QUANTITY_RESERVE);

        externalTaskService.complete(externalTask, variables);

        Logger.getLogger("show-assortment")
                .log(Level.INFO, "Clothes Model = {0}; quantity reserve = {1}",
                        new Object[]{CLOTHES_TYPE, QUANTITY_RESERVE});
    }
}
