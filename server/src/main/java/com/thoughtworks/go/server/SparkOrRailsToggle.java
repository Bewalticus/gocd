/*
 * Copyright 2020 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package com.thoughtworks.go.server;

import com.thoughtworks.go.server.service.support.toggle.Toggles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SparkOrRailsToggle {

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "unused"})
    private void basedOnToggle(String toggle, HttpServletRequest request) {
        if (Toggles.isToggleOn(toggle)) {
            request.setAttribute("sparkOrRails", "rails");
        } else {
            request.setAttribute("sparkOrRails", "spark");
        }
    }

    public void testConnectionAPI(HttpServletRequest request, HttpServletResponse response) {
        basedOnToggle(Toggles.USE_RAILS_BASED_MATERIAL_TEST_CONNECTION_API, request);
    }

    public void feedsApi(HttpServletRequest request, HttpServletResponse response) {
        basedOnToggle(Toggles.NEW_FEED_API, request);
    }

    public void webhooks(HttpServletRequest request, HttpServletResponse response) {
        basedOnToggle(Toggles.RAILS_WEBHOOK_API, request);
    }

    public void comparisonSPA(HttpServletRequest request, HttpServletResponse response) {
        basedOnToggle(Toggles.SHOW_OLD_COMPARISON_SPA, request);
    }
}
