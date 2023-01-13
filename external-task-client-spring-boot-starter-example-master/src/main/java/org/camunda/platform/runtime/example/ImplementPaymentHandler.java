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
import org.rest.PaymentResult;
import org.rest.RestClient;
import org.rest.UserOrder;
import org.soap2.UserReserve;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("implement-payment") // create a subscription for this topic name
public class ImplementPaymentHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        Logger.getLogger("implement-payment").log(Level.INFO, "Stage implement-payment");
        UserReserve reserve = (UserReserve) externalTask.getVariable("UserReserve");

        UserOrder order = new UserOrder();
        order.setProductId(reserve.getClothes().getId());
        order.setQuantity(reserve.getQuantity());

        try {
            RestClient restClient = new RestClient();
            PaymentResult paymentResult = restClient.postRequestPayment(order);
            System.out.println("Payment completed");
            System.out.println(paymentResult.getProductInfo() + " " +
                    "| quantity: " + paymentResult.getQuantity() + " " +
                    "| total sum: " + paymentResult.getPrice() + " " +
                    "| result info: " + paymentResult.getResultMessage());

           // Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        externalTaskService.complete(externalTask);
        Logger.getLogger("implement-payment").log(Level.INFO, "Completed");
    }

}
