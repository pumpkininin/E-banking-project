<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <meta name="generator" content="Hugo 0.80.0">
    <title>Transfer</title>


	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	
	<script src = "js/transfer.js" defer></script>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
   
  </head>
  <body class="bg-light">

  <div class="page" style = "width:70%; margin: auto">
    <jsp:include page="../slideshow.jsp"></jsp:include>
    <jsp:include page="../nav-bar.jsp"></jsp:include>
  <main>
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="" alt="" width="72" height="57">
      <h2>Transfer form</h2>
      <p class="lead">Fill all required information to start transfer process.</p><br>
      <strong>Make sure that there are no mistakes in entering receiver account number</strong>
    </div>

    
      <div class="col-md-7 col-lg-8" style="margin:auto">
        <h4 class="mb-3">Transfer form</h4>
        <form class="needs-validation" novalidate action="/customer/transfer-confirm-form" method="POST">
          <div class="row g-3">
	          <div class="col-sm-12">
	              <label for="money" class="form-label">Amount of money you want to transfer (VND)</label>
	              <input type="number" class="form-control" step = "100000" id="money" name = "money" placeholder="" value="${transferInfo.get(0)}" required>
                <div style="color:red;">
                  ${transferInfo.get(3)}
                </div>
              </div>


            <div class="col-12">
              <label for="username" class="form-label">Receiver account number</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" name="receiverId" id="username" placeholder="" value="${transferInfo.get(1)}" required>
              </div>
              <div style="color:red;">
              ${transferInfo.get(4)}
              </div>

            </div>

            
          </div>
          <br><br>

          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" name="submit-btn" type="submit">Continue to transfer money</button>
        </form>
      </div>
    
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>



  <jsp:include page="../footer.jsp"/>
  </body>
  <style>
    div.page{
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
  </style>
</html>
