<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand float-left" href="#"><i
		class="fa-brands fa-pagelines fa-2x px-1"></i>Pannello amministratore</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarScroll" aria-controls="navbarScroll"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarScroll">
		<%
		String user = (String) session.getAttribute("nome_admin");
		if (user == null) {
		%>
		<ul class="navbar-nav ml-auto my-2 my-lg-0" style="max-height: 100px;">
			<li class="nav-item">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="fa-solid fa-right-to-bracket px-1"></i>Login <span
							class="sr-only"></span>
					</button>
					<form action="/<%=application.getServletContextName()%>/controllo"
						method="post" class="form-horizontal">
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item"> <span class="input-group-addon">
									<i class="glyphicon glyphicon-user"></i>
							</span> <input type="text" name="nome_admin" placeholder="Username..."
								class="form-control" required></a> <a class="dropdown-item" href="#">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-lock"></i>
							</span> <input type="password" name="cod_admin" placeholder="Password..."
								class="form-control" required>
							</a> <a class="dropdown-item"><button type="submit"
									class="btn btn-dark">Login</button></a>
						</div>
					</form>
				</div>
			</li>
			<li class="nav-item px-2"><a class="nav-link" href="#"><i
					class="fa-solid fa-user-pen px-1"></i>Sign-up</a></li>
		</ul>
		<%
		} else {
		%>
		<ul class="navbar-nav ml-auto my-2 my-lg-0" style="max-height: 100px;">
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fa-solid fa-user-bounty-hunter px-1"></i><%=user%></a></li>
			<li class="nav-item px-2"><a href="logout.jsp"><i
					class="fa-solid fa-arrow-up-left-from-circle px-1"></i>Logout</a></li>
		</ul>
	</div>
	<%
	}
	%>
</nav>
