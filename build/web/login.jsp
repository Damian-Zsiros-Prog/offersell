<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/login.css" />
        <title>Iniciar sesion - OfferSell</title>
    </head>
    <body>

        <jsp:include page="componentes/headerComp.jsp"></jsp:include>

            <main>
                <main>
                    <div class="form-container">
                    <%
                        if (request.getSession().getAttribute("message") != null) {
                    %>
                    <script>alert('<%= request.getSession().getAttribute("message")%>')</script>
                    <%
                            request.getSession().setAttribute("message", null);
                        }
                    %>
                    <h1 class="title-form">Iniciar sesion</h1>
                    <form class="form" action="UsersController?action=loginUser" method="POST">
                        <div class="form-group">
                            <label for="email">Correo electrÃ³nico</label>
                            <input
                                type="email"
                                class="form-control"
                                name="email"
                                placeholder="Correo electrÃ³nico"
                                required
                                />
                        </div>
                        <div class="form-group">
                            <label for="password">ContraseÃ±a</label>
                            <input
                                type="password"
                                class="form-control"
                                name="password"
                                placeholder="ContraseÃ±a"
                                required
                                />
                        </div>
                        <div
                            class="g-recaptchas"
                            data-sitekey="6LeyQWchAAAAAF5yisaa2SzD7TxUNnYCx4xJovfs"
                            ></div>
                        <button type="submit" class="primary-button">Iniciar sesion</button>
                    </form>
                </div>
            </main>
            <script
                src="https://www.google.com/recaptcha/api.js?hl=es"
                async
                defer
            ></script>
    </body>
</html>
