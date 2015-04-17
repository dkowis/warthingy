/** *
  * Copyright 2014 Rackspace US, Inc.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package com.rackspace.hax

import java.io.{BufferedInputStream, BufferedOutputStream, InputStream, OutputStream}
import javax.servlet.{ServletException, FilterConfig, ServletConfig}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class ConfigMapper(fc : FilterConfig) extends ServletConfig {
  override def getInitParameter( name : String)  : String = fc.getInitParameter(name)
  override def getInitParameterNames = fc.getInitParameterNames
  override def getServletContext = fc.getServletContext
  override def getServletName = fc.getFilterName+" theServlet"
}
