<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Loan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>





    <!-- Bootstrap core CSS -->


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
    <link href="form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="page" style = "width:70%; margin: auto">
    <jsp:include page="../slideshow.jsp"></jsp:include>
    <jsp:include page="../nav-bar.jsp"></jsp:include>
    <div class="container">
        <main>
            <div class="py-5 text-center">

                <h2>Confirm deposit</h2>
                <p class="lead">Below is all information of your deposit process. Make sure that all of them are correct.
                    To finish this process please confirm your password</p>
            </div>
            <form class="needs-validation" novalidate action="/customer/deposit-finish" method="POST">
            <div class="row g-3" style="display: flex; justify-content: space-around;">
                <div class="col-md-5 col-lg-4 order-md-last">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Your deposit information</span>
                        <span class="badge bg-secondary rounded-pill">3</span>
                    </h4>
                    <ul  modelAttribute="moneyDeposit" class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Amount of money</h6>

                            </div>
                            <input size = "10" class="text-muted money" required name = "money-deposit" value="${moneyDeposit.get(0)}" readonly/>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">Date</h6>

                            </div>
                            <span class="text-muted"></span>
                        </li>
                    </ul>
                </div>
                <div class="col-md-7 col-lg-4">
                    <h4 class="mb-3">Confirm your password</h4>
                        <div class="col-12">
                            <label for="password" class="form-label">Password</label>
                            <div class="input-group has-validation">

                                <input type="password" class="form-control" id="password" name = "password" placeholder="" required>

                            </div>
                            <div style="color:red;">
                                ${moneyDeposit.get(1)}
                            </div>
                        </div>



                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit">Finish</button>
                    </form>
                </div>
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
</div>


<jsp:include page="../footer.jsp"/>
</body>
<style>
    div.page{
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
</style>
</html>
