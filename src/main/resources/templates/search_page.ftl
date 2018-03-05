<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stack Exchanger Finder</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error {
            border-color: red;
        }
    </style>
</head>
<body>
<div class="row" style="text-align: center">
    <h3>Get data from stackoverflow</h3>
</div>
<div class="container" style="text-overflow: ellipsis;">
    <div class="row" style="margin-top: 100px">
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" id="search-input" maxlength="100" style="width: 80%">
                <button class="btn btn-default" type="submit" id="search-button">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </div>
        </div>
        <div class="col-lg-4">
            <button class="btn btn-light" style="float: left" id="prev">prev</button>
            <input type="number" class="form-control" placeholder="Page" id="page" maxlength="10" min="1" value="1" style="width: 20%; float: left">
            <button class="btn btn-light" style="float: left" id="next">next</button>
        </div>
    </div>
    <div class="row" style="display: none; margin-top: 100px;" id="dataTable">
        <table class="table table-striped table-bordered table-responsive">
            <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>title</th>
                <th>last edit date</th>
                <th>link</th>
                <th>author</th>
            </tr>
            </thead>
            <tbody class="table-hover" id="search-result">

            </tbody>
        </table>
    </div>
</div>
<div style="text-align: center; display: none" id="emptyResult">
    <h1>Nothing found</h1>
</div>


<script src="/resources/js/lib/jquery.min.3.3.1.js"></script>
<script src="/resources/js/lib/bootstrap.min.js"></script>
<script src="/resources/js/custom/search-page.js"></script>
</body>
</html>