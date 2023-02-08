<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/register.css" />
        <title>Regí­strate - OfferSell</title>
    </head>
    <body>
        
        <jsp:include page="componentes/headerComp.jsp"></jsp:include>

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
                <h1 class="title-form">Regí­strate</h1>
                <form class="form" action="UsersController?action=registerUser" method="POST" autocomplete="off">
                    <div class="form-group">
                        <label for="names">Nombre</label>
                        <input
                            type="text"
                            class="form-control"
                            name="names"
                            placeholder="Nombres"
                            required
                            />
                    </div>
                    <div class="form-group">
                        <label for="surnames">Apellidos</label>
                        <input
                            type="text"
                            class="form-control"
                            name="surnames"
                            placeholder="Apellido"
                            required
                            />
                    </div>
                    <div class="form-group">
                        <label for="address">Direccion</label>
                        <input
                            type="text"
                            class="form-control"
                            name="adress"
                            placeholder="DirecciÃ³n"
                            required
                            />
                    </div>
                    <div class="form-group">
                        <label for="email">Correo electronico</label>
                        <input
                            type="email"
                            class="form-control"
                            name="email"
                            placeholder="Correo electrÃ³nico"
                            required
                            />
                    </div>
                    <div class="form-group">
                        <label for="address">Telefono</label>
                        <input
                            type="number"
                            class="form-control"
                            name="phone"
                            placeholder="Telefono"
                            required
                            />
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="ContraseÃ±a"
                            required
                            />
                    </div>
                    <button type="submit" class="primary-button">Regístrarme</button>
                </form>
            </div>
        </main>

    </body>
</html>
