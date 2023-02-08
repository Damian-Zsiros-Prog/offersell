<%@page import="java.util.List"%>
<%@page import="co.edu.unisinu.desarrollo1.model.CategoryArticle"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.CategoriesArticlesDAO"%>
<header class="header">
    <section class="top_bar">
        <div class="logo">
            <a href="./index.jsp" class="logo-link">
                <img
                    src="https://i.pinimg.com/originals/f0/dd/ec/f0ddec76cda8ee2756e663924856f81e.png"
                    alt=""
                    class="logo-img"
                    />
            </a>
        </div>
        <ul class="nav">
            <%
                if (request.getSession().getAttribute("userLogued") != null) {
            %>
            <li class="nav-item">
                <a class="primary-button nav-link" href="CloseSessionController" 
                   >Cerrar sesion</a
                >
            </li>
            <li class="nav-item">
                <a class="primary-button nav-link" href="./SRCE ADMIN/home.jsp" 
                   >Dashboard</a
                >
            </li>
            <%
            } else {
            %>
            <li class="nav-item">
                <a class="primary-button nav-link" href="login.jsp" 
                   >Iniciar sesión</a
                >
            </li>
            <li class="nav-item">
                <a class="primary-button nav-link" href="register.jsp">Registrarse</a
                >
            </li>
            <%
                }
            %>
        </ul>
    </section>
    <section class="categories-bar">
        <nav>
            <ul class="nav">
                <li class="nav-item"><a href="./index.jsp">Inicio</a></li>
                    <%
                        CategoriesArticlesDAO categoryArticle = new CategoriesArticlesDAO();
                        List<CategoryArticle> categoriesList = categoryArticle.listCategories();
                        for (CategoryArticle category : categoriesList) {
                    %>
                <li class="nav-item">
                    <a 
                        href="./index.jsp?categoryId=<%= category.getIdCategory()%>"
                        >
                        <%= category.getName()%>
                    </a> 
                </li>                         
                <%
                    }
                %>
            </ul>
        </nav>
    </section>
</header>
