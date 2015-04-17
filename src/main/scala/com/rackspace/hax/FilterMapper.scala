/***
 *   Copyright 2015 Rackspace US, Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.rackspace.hax

import java.io.File
import javax.servlet.{Filter, FilterChain, FilterConfig, ServletException, ServletRequest, ServletResponse}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import org.python.tools.fireside.servlet.WSGIServlet

class FilterMapper extends Filter {
  val servlet = new WSGIServlet

  override def init(config : FilterConfig) : Unit = {
    servlet.init(new ConfigMapper(config))
  }

  override def doFilter (req : ServletRequest, resp : ServletResponse, chain : FilterChain) : Unit = {
    servlet.service (req, resp)
    chain.doFilter(req, resp)
  }

  override def destroy : Unit = {
    servlet.destroy()
  }
}
