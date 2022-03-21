<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand float-left" href="#"><i class="fa-solid fa-suitcase p-2"></i>Pannello amministratore</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarScroll">
			<%
				String user = (String) session.getAttribute("username");
				if(user == null) {
			%>
		    <ul class="navbar-nav ml-auto my-2 my-lg-0" style="max-height: 100px;">
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Login <span class="sr-only">(current)</span></a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Sign-up</a>
		      	</li>
		    </ul>
		   	<%
				} else {
			%>
			<ul class="navbar-nav ml-auto my-2 my-lg-0" style="max-height: 100px;">
		      	<li class="nav-item">
		        	<a class="nav-link" href="#"><%=user%></a>
		      	</li>
		      	<li class="nav-item">
		        	<a href="logout.jsp"><i class="fa-solid fa-right-from-bracket p-2"></i>Logout</a>
		      	</li>
		    </ul>	
		</div>
			<%
				}
			%>
</nav>
