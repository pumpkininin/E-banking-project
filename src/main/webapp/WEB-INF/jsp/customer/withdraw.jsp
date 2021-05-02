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

			<h2>Withdraw form</h2>
			<p class="lead"></p>Choose an account you want to withdraw. <br>
			<strong>In case you want to withdraw saving account, you must withdraw all money in that account!</strong>
		</div>


		<div class="col-md-7 col-lg-8" style="margin:auto">
			<h4 class="mb-3">Withdraw form</h4>
			<form class="needs-validation" novalidate action="/customer/withdraw-confirm-form" method="POST" modelAttributes="accountInfo" modelAttributes="savingInfo">
				<div class="row g-3">


					<div class="col-12 withdraw-form">
						<label for="account" class="form-label">Which account you want to withdraw?</label>
						<div class="input-group has-validation">
							<select id="account" name="account">
								<option value="deposit">Deposit account</option>
								<option value="saving">Saving account</option>
							</select>

						</div>
						<br><br>
						<ul class="list-group mb-3" id="saving-info" style="width:50%; display:none;">
							<li class="list-group-item d-flex justify-content-between lh-sm">
								<div>
									<h6 class="my-0">Saving amount</h6>
									<input size = "10" class="text-muted money" required name = "money" value="${savingInfo.amount}" readonly/>

								</div>
								<span class="text-muted"></span>
							</li>
							<li class="list-group-item d-flex justify-content-between lh-sm">
								<div>
									<h6 class="my-0">Duartion</h6>
									<input size = "10" class="text-muted money" required name = "fee" value="${savingInfo.duration}" readonly/>

								</div>
								<span class="text-muted"></span>
							</li>
						</ul>
						<ul class="list-group mb-3" id="account-info" style=" width:50%; display:none;">
							<li class="list-group-item d-flex justify-content-between lh-sm">
								<div>
									<h6 class="my-0">Balance</h6>
									<input size = "10" class="text-muted money" required name = "money" value="${accountInfo.balance}" readonly/>

								</div>
								<span class="text-muted"></span>
							</li>
					</div>


				</div>
				<br><br>
				<div class="form-check">
					<button class ="btn btn-success btn-check-account" type="button" name=check-btn" >Check account</button>

				</div>
				<script>
                    var checkbtn = document.querySelector(".btn-check-account");
                    var account = document.querySelector('#account')
                    var savingInfo = document.querySelector("#saving-info");
                    var accountInfo = document.querySelector("#account-info");
                    checkbtn.addEventListener("click",() => {
                        if(account.value === "saving"){
                            savingInfo.style.display="block";
                            accountInfo.style.display= "none" ;
						}else{
                            savingInfo.style.display= "none" ;
                            accountInfo.style.display="block";
						}
					})
				</script>
				<hr class="my-4">

				<button class="w-100 btn btn-primary btn-lg" name="submit-btn" type="submit">Continue</button>
			</form>
			<br><br><br>
		</div>

	</main>


</div>



<jsp:include page="../footer.jsp"/>
</body>
<style>
    div.page{
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
</style>
</html>
