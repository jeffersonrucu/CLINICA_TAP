<section class="login">
    <div class="container">
        <div class="card">
            <div class="card-action blue darken-1 white-text">
                <h3>Login</h3>
            </div>

            <form class="card-content" action="pages/home.jsp">
                <div>
                    <fieldset class="form-field">
                        <label for="username">Usuario</label>
                        <input type="text" id="username" name="username">
                    </fieldset>

                    <fieldset class="form-field">
                        <label for="password">Senha</label>
                        <input type="password" id="password" name="password">
                    </fieldset>

<%--                    <div class="sign-up">--%>
<%--                        <a href="index.jsp">Cadastre-se</a>--%>
<%--                    </div>--%>
                </div>

                <button type="submit" class="btn btn-large waves-effect waves-dark blue darken-1">Entrar</button>
            </form>
        </div>
    </div>
</section>