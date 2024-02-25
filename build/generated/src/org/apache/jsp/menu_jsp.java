package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- HEADER -->\n");
      out.write("<header>\n");
      out.write("    <!-- TOP HEADER -->\n");
      out.write("<!--    <div id=\"top-header\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"header-links pull-left\">\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-phone\"></i> +84 962313361</a></li>\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-envelope-o\"></i> anhtqhe172548@fpt.edu.vn.com</a></li>\n");
      out.write("                <li><a href=\"https://uni.fpt.edu.vn/en-US/Default.aspx\"><i class=\"fa fa-map-marker\"></i> FPT University</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"header-links pull-right\">\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-dollar\"></i> USD</a></li>\n");
      out.write("                    ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>-->\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <style>\n");
      out.write("        nav {\n");
      out.write("            background-color: #f8f8f8; /* Màu trắng sữa */\n");
      out.write("            overflow: hidden;\n");
      out.write("            text-align: right;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a, nav span {\n");
      out.write("            display: inline-block;\n");
      out.write("            color: black; /* Màu đen */\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 10px 12px; /* Giảm khoảng cách */\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-family: Arial, sans-serif; /* Font Arial */\n");
      out.write("            font-weight: bold; /* In đậm */\n");
      out.write("            font-size: 12px; /* Cỡ chữ nhỏ hơn */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a:hover {\n");
      out.write("            background-color: #ddd;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav span {\n");
      out.write("            color: #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown {\n");
      out.write("            display: none;\n");
      out.write("            position: absolute;\n");
      out.write("            background-color: #f8f8f8;\n");
      out.write("            box-shadow: 0 8px 16px rgba(0,0,0,0.2);\n");
      out.write("            z-index: 1;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown a {\n");
      out.write("            display: block;\n");
      out.write("            color: black;\n");
      out.write("            padding: 10px 12px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown a:hover {\n");
      out.write("            background-color: #ddd;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<nav id=\"navbar\">\n");
      out.write("    <!-- Placeholder links, actual content will be added by JavaScript -->\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    // Replace the following logic with your own JSTL logic to determine login status\n");
      out.write("    const isLoggedIn = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("\n");
      out.write("    // Function to toggle the dropdown content\n");
      out.write("    function toggleDropdown() {\n");
      out.write("        document.getElementById(\"dropdownContent\").classList.toggle(\"show\");\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // Populate the navbar based on the login status\n");
      out.write("    function updateNavbar() {\n");
      out.write("        const navbar = document.getElementById(\"navbar\");\n");
      out.write("\n");
      out.write("        // Clear existing content\n");
      out.write("        navbar.innerHTML = \"\";\n");
      out.write("\n");
      out.write("        if (isLoggedIn) {\n");
      out.write("            // If logged in, show logout, hi + username, and user icon\n");
      out.write("            navbar.innerHTML += `<a href=\"#logout\">Logout</a>`;\n");
      out.write("            navbar.innerHTML += `<span>|</span>`;\n");
      out.write("            navbar.innerHTML += `<a href=\"#hi\">Hi, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>`;\n");
      out.write("            navbar.innerHTML += `<span>|</span>`;\n");
      out.write("            navbar.innerHTML += `<span onclick=\"toggleDropdown()\">User Icon</span>`;\n");
      out.write("            navbar.innerHTML += `<div id=\"dropdownContent\" class=\"dropdown\">\n");
      out.write("                                    <a href=\"#logout\">Logout</a>\n");
      out.write("                                    <a href=\"#account\">Account</a>\n");
      out.write("                                    <a href=\"#profile\">Profile</a>\n");
      out.write("                                  </div>`;\n");
      out.write("        } else {\n");
      out.write("            // If not logged in, show help, register, and signin\n");
      out.write("            navbar.innerHTML += `<a href=\"#help\">Help</a>`;\n");
      out.write("            navbar.innerHTML += `<span>|</span>`;\n");
      out.write("            navbar.innerHTML += `<a href=\"#register\">Register</a>`;\n");
      out.write("            navbar.innerHTML += `<span>|</span>`;\n");
      out.write("            navbar.innerHTML += `<a href=\"#signin\">Signin</a>`;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // Call the updateNavbar function when the page loads\n");
      out.write("    window.onload = updateNavbar;\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("    <!-- /TOP HEADER -->\n");
      out.write("\n");
      out.write("    <!-- MAIN HEADER -->\n");
      out.write("    <div id=\"header\" style=\"background-image: url('./img/loginform.jpeg')\">\n");
      out.write("        <!-- container -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- row -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- LOGO -->\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"header-logo\">\n");
      out.write("                        <a href=\"#\" class=\"logo\">\n");
      out.write("                            <img src=\"./img/logo5.png\" alt=\"\">\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /LOGO -->\n");
      out.write("\n");
      out.write("                <!-- SEARCH BAR -->\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"header-search\">\n");
      out.write("                        <form action=\"#\" >\n");
      out.write("                            <select class=\"input-select\" name=\"searchID\">\n");
      out.write("                                <option value=\"0\">All Iteams</option>\n");
      out.write("                                <!--ADD JSTL HERE -->\n");
      out.write("                            </select>\n");
      out.write("                            <input class=\"input\" placeholder=\"Search here\" name=\"txt\" type=\"text\" value=\"\">\n");
      out.write("                            <button class=\"search-btn\" type=\"submit\">Search</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /SEARCH BAR -->\n");
      out.write("\n");
      out.write("                <!-- ACCOUNT -->\n");
      out.write("                <div class=\"col-md-3 clearfix\">\n");
      out.write("                    <div class=\"header-ctn\">\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        <!-- Menu Toogle -->\n");
      out.write("                        <div class=\"menu-toggle\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\n");
      out.write("                                <span>Menu</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /Menu Toogle -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /ACCOUNT -->\n");
      out.write("            </div>\n");
      out.write("            <!-- row -->\n");
      out.write("        </div>\n");
      out.write("        <!-- container -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /MAIN HEADER -->\n");
      out.write("</header>\n");
      out.write("<!-- /HEADER -->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.permissionID == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li><a href=\"manager\"><i class=\"fa fa-user-o\"></i>Manager Product</a></li>\n");
        out.write("                    \n");
        out.write("                    \n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.permissionID == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    \n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li><a href=\"logout\"><i class=\"fa fa-user-o\"></i> Logout(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(")</a></li>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li><a href=\"login\"><i class=\"fa fa-user-o\"></i> Login</a></li>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
