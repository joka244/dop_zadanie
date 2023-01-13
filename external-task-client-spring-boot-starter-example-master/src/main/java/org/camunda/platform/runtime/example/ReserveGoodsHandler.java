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
import org.soap2.ReservationClient;
import org.soap2.UserReserve;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.soap2.ReservationClient.getWSDLURL;

@Component
@ExternalTaskSubscription("reserve-goods") // create a subscription for this topic name
public class ReserveGoodsHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Logger.getLogger("reserve-goods")
                .log(Level.INFO, "Stage reserve-goods");

        String clothesModel = (String) externalTask.getVariable("clothesModel");
        int quantityReserve = (int) externalTask.getVariable("quantityReserve");

        Logger.getLogger("reserve-goods")
                .log(Level.INFO, "Trying reserves clothes model = {0};  quantity reserve = {1}",
                        new Object[]{clothesModel, quantityReserve});

        URL url = getWSDLURL("http://localhost:8088/Reservation?wsdl");
        ReservationClient resClient = new ReservationClient();
        UserReserve userReserve = resClient.processCallback(url, clothesModel, quantityReserve);

        VariableMap variables = Variables.createVariables();

        if (userReserve != null) {
            Logger.getLogger("reserve-goods").log(Level.INFO, "Product reserved");
            variables.put("reserved", true);
            variables.put("UserReserve", userReserve);
            resClient.printUserReserve(userReserve);
        } else {
            Logger.getLogger("reserve-goods").log(Level.INFO, "Not added");
            variables.put("reserved", false);
        }
        externalTaskService.complete(externalTask, variables);
    }
}
