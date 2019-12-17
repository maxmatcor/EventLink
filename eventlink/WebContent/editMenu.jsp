<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>EventLink-Editor</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/Icono.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">

  <!-- =======================================================
    Theme Name: EstateAgency
    Theme URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>
	<%if (session.getAttribute("user")== null){ 
		response.sendRedirect("index.jsp");} %><!-- verifica la existencia de inicio de session-->
		
		<!--/ Nav Star /-->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
        <span></span>
        <span></span>
        <span></span>
      <a class="navbar-brand text-brand" href="indexControler">Event<span class="color-b">Link</span></a>
      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" href="indexControler">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">Sobre Nosotros</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="editalta.jsp">Crear Eventos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="eventControler">Mis Eventos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Necesitas Ayuda?</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="LogOut">Cerrar Sesion</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Nav End /-->
</br>
</br>
</br>
</br>
</br>

<!--/ Carousel Star /-->
  <div class="intro intro-carousel" onclick="location.href='eventControler';" style="cursor: pointer;">
    <div id="carousel" class="owl-carousel owl-theme">
      <div class="carousel-item-a intro-item bg-image" style="background-image: url(img/slide1.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <h1 class="intro-title mb-4">
                      <span class="color-b">Los mas Buscados </span>
                      <br> Rock In Rio</h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">Musica</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="carousel-item-a intro-item bg-image" style="background-image: url(img/slide2.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <h1 class="intro-title mb-4">
                      <span class="color-b">Los mas Buscados</span>
                      <br> Los Miserables</h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">Teatro</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="carousel-item-a intro-item bg-image" style="background-image: url(img/slide3.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    <h1 class="intro-title mb-4">
                      <span class="color-b">Los mas Buscados</span>
                      <br>El mejor infarto de mi vida </h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">Literatura</span></a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--/ Carousel end /-->

	  <!-- WELCOME SECTION -->
  <div class="container"onclick="location.href='regControler';" style="cursor: pointer;">
    <div class="row mt">
      <div class="col-lg-8">
      </div>
      <div class="col-lg-4">
      </br>
             <p class="pull-right" onclick="location.href='regControler';" style="cursor: pointer;"><a class="price-a"><%=(String)session.getAttribute("user")%></a></p>
      </div>
    </div>
    <!-- /row -->
  </div>
  <!-- /.container -->

  <!--/ Menu Star /-->
  <section class="section-property section-t8">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="title-wrap d-flex justify-content-between">
            <div class="title-box">
              <h2 class="title-a">Menu</h2>
            </div>
          </div>
        </div>
      </div>
      <div id="property-carousel" class="owl-carousel owl-theme">
        <div class="carousel-item-b" onclick="location.href='editalta.jsp';" style="cursor: pointer;">
          <div class="card-box-a card-shadow">
            <div class="img-box-a">
              <img src="img/avataresusuario.jpg" alt="" class="img-a img-fluid">
            </div>
            <div class="card-overlay"onclick="location.href='editalta.jsp';" style="cursor: pointer;">
              <div class="card-overlay-a-content">
                <div class="card-body-a">
                  <div class="price-box d-flex">
                    <span class="price-a">Evento
            <a href="editalta.jsp">Crear</a></span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item-b"onclick="location.href='eventControler';" style="cursor: pointer;">
          <div class="card-box-a card-shadow">
            <div class="img-box-a">
                   <img src="img/events.png" alt="" class="img-a img-fluid">
            </div>
            <div class="card-overlay"onclick="location.href='eventControler';" style="cursor: pointer;">
              <div class="card-overlay-a-content">
                <div class="card-body-a">
                  <div class="price-box d-flex">
                    <span class="price-a">Mis Eventos         
                    <a  href="eventControler">Ver</a></span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item-b"onclick="location.href='contact.jsp';" style="cursor: pointer;">
          <div class="card-box-a card-shadow">
            <div class="img-box-a">
                   <img src="img/userhelp.png" alt="" class="img-a img-fluid">
            </div>
            <div class="card-overlay"onclick="location.href='contact.jsp';" style="cursor: pointer;">
              <div class="card-overlay-a-content">
                <div class="card-body-a">
                  <div class="price-box d-flex">
                    <span class="price-a">Soporte
			<a  href="contact.jsp">Ir</a></span>
                  </div>       
                </div>
              </div>
            </div>
          </div>
        </div>
  </section>
  <!--/ Menu End /-->
 

  <!--/ Testimonials Star /-->
  <section class="section-testimonials section-t8 nav-arrow-a">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="title-wrap d-flex justify-content-between">
            <div class="title-box">
              <h2 class="title-a">Tips</h2>
            </div>
          </div>
        </div>
      </div>
      <div id="testimonial-carousel" class="owl-carousel owl-arrow">
        <div class="carousel-item-a">
          <div class="testimonials-box">
            <div class="row">
              <div class="col-sm-12 col-md-6">
                <div class="testimonial-img">
                  <img src="img/Grupo-de-trabajo-mixto.jpg" alt="" class="img-fluid">
                </div>
              </div>
              <div class="col-sm-12 col-md-6">
                <div class="testimonial-ico">
                  <span class="ion-ios-quote"></span>
                </div>
                <div class="testimonials-content">
                  <p class="testimonial-text">
                   ¿Es tu primer evento y no sabes por dónde comenzar? o 
                   ¿has tenido alguna mala experiencia que no quieres volver a repetir? 
                   No te preocupes, te dejamos algunos útiles consejos para organizar eventos. 
                   En EventLink llevamos mucho tiempo ofreciendo servicios tecnológicos para quienes organizan eventos 
                   y queremos compartir contigo todo lo que nos han enseñado. 
                   Apunta, aquí van 5 consejos para empezar a organizar eventos.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item-a">
          <div class="testimonials-box">
            <div class="row">
              <div class="col-sm-12 col-md-6">
                <div class="testimonial-img">
                  <img src="/img/numeros-metricas-eventos.jpg" alt="" class="img-fluid">
                </div>
              </div>
              <div class="col-sm-12 col-md-6">
                <div class="testimonial-ico">
                  <span class="ion-ios-quote"></span>
                </div>
                <div class="testimonials-content">
                  <p class="testimonial-text">
                    Cuando hablamos de números y métricas en un evento el panorama es bastante amplio. 
                    En la etapa previa podemos hablar de ciertos puntos claves como: 
                    Calcular la cantidad de asistentes estimada en base a los inscriptos totales, 
                    la duración de las charlas y el gasto por asistente, entre otros. 
                    Mientras que en la etapa posterior podemos hacer una analítica más precisa 
                    y desmenuzar el evento en números de acuerdo a lo que pasó en redes sociales,
                     a los resultados de las encuestas y a todas las métricas que fuimos recolectando.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--/ Testimonials End /-->

  <!--/ footer Star /-->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <nav class="nav-footer">
            <ul class="list-inline">
              <li class="list-inline-item">
                <a href="indexControler">Home</a>
              </li>
              <li class="list-inline-item">
                <a href="about.jsp">Quienes somos</a>
              </li>
              <li class="list-inline-item">
                <a href="contact.jsp">Contacto</a>
              </li>
            </ul>
          </nav>
          <div class="socials-a">
            <ul class="list-inline">
              <li class="list-inline-item">
                <a href="https://www.facebook.com/">
                  <i class="fa fa-facebook" aria-hidden="true"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="https://twitter.com/">
                  <i class="fa fa-twitter" aria-hidden="true"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="https://www.instagram.com/">
                  <i class="fa fa-instagram" aria-hidden="true"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="https://ar.pinterest.com/">
                  <i class="fa fa-pinterest-p" aria-hidden="true"></i>
                </a>
              </li>
               </ul>
          </div>
          <div class="copyright-footer">
            <p class="copyright color-text-a">
              &copy; Copyright
              <span class="color-a">EventLink</span> Todos los derechos reservados.
            </p>
          </div>
          <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=EstateAgency
            -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!--/ Footer End /-->


  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <div id="preloader"></div>

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/popper/popper.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/scrollreveal/scrollreveal.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>
