<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Your balance</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>

</head>
<body>
	<div class="page" style = "width:75%; margin: auto">
		<jsp:include page="../slideshow.jsp"></jsp:include>
		<jsp:include page="../nav-bar.jsp"></jsp:include>
			<div class="nav-scroller bg--body shadow-sm">

			</div>

			<main class="container">
				<div class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
					<img class="me-3" src="../assets/brand/bootstrap-logo-white.svg" alt="" width="48" height="38">
					<div class="lh-1">
						<h1 class="h6 mb-0 text-white lh-1">Bootstrap</h1>
						<small>Since 2021</small>
					</div>
				</div>

				<div class="my-3 p-3 bg-body rounded shadow-sm" modelAttributes="account">
					<h6 class="border-bottom pb-2 mb-0">Your wallet</h6>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Your Account ID</strong>
							${account.account_id}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#e83e8c"/><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">You balance</strong>
							${account.balance}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Open date</strong>
							${account.open_date}
						</p>
					</div>
					<small class="d-block text-end mt-3">
						<a href="#">More details</a>
					</small>
				</div>
				<div class="my-3 p-3 bg-body rounded shadow-sm" modelAttributes="saving">
					<h6 class="border-bottom pb-2 mb-0">Your saving</h6>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Your Saving ID</strong>
							${saving.saving_id}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#e83e8c"/><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">You saving amount</strong>
							${saving.amount}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Open date</strong>
							${saving.open_date}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Saving rate</strong>
							${saving.saving_rate}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Duration</strong>
							${saving.duration}
						</p>
					</div>
					<small class="d-block text-end mt-3">
						<a href="#">More details</a>
					</small>
				</div>
				<div class="my-3 p-3 bg-body rounded shadow-sm" modelAttributes="loan">
					<h6 class="border-bottom pb-2 mb-0">Your loan detail</h6>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Your loan id</strong>
							${loan.loan_id}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#e83e8c"/><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">You loan amount</strong>
							${loan.loan_amount}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Loan date</strong>
							${loan.loan_date}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f52c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Loan rate</strong>
							${loan.interest_rate}
						</p>
					</div>
					<div class="d-flex text-muted pt-3">
						<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="rgb(0,0,255)"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

						<p class="pb-3 mb-0 small lh-sm border-bottom">
							<strong class="d-block text-gray-dark">Duration</strong>
							${loan.duration}
						</p>
					</div>
					<small class="d-block text-end mt-3">
						<a href="#">More details</a>
					</small>
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