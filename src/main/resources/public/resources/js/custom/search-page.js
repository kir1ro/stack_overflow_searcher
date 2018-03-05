$(document).on("click", "#search-button", function () {
    getQuestions($("#search-input").val(), $("#page").val());
})
$(document).on("click", "#next", function () {
    var page = $('#page').val();
    $('#page').val(++page);
})
$(document).on("click", "#prev", function () {
    var page = $('#page').val();
    page--;
    if (page <= 0) {
        page = 1;
    }
    $('#page').val(page);
})

function getQuestions(title, page) {
    var data = {
        "title": title,
        "page": page
    }
    removeErrors();
    checkValidData();
    if (contentHasErrors()) {
        return;
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/questions",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (result) {
            clearData();
            if (result.questions.length > 0) {
                $('#dataTable').show();
            } else {
                $('#emptyResult').show();
            }

            $.each(result.questions, function (index, question) {
                var cssClass = "";
                if (question.is_answered) {
                    cssClass = "mark";
                }
                var tr = "<tr class=" + cssClass + "><td>" + (index + 1) + "</td>" +
                    "<td>" + question.title + "</td>" +
                    "<td>" + getDate(question.last_activity_date) + "</td>" +
                    "<td><a type=\"button\" href='" + question.link + "' class=\"btn btn-link\">Link</a></td>" +
                    "<td>" + question.owner.display_name + "</td></tr>"

                $('#search-result').append(tr);
            })
            console.log(result);
        },
        error: function (e) {
            alert("Something went wrong! Please, refresh this page.")
        }
    });
}

function removeErrors() {
    $("#search-input").removeClass("error");
    $("#page").removeClass("error");
}

function contentHasErrors() {
    if ($(".container .error").length > 0) {
        return true;
    }
    return false;
}

function checkValidData() {
    var title = $("#search-input").val().trim();
    var page = parseInt($('#page').val().trim());
    if (title == null || title == "") {
        $("#search-input").addClass("error");
    }
    console.log(Number.isInteger(page))
    if (page == null || !Number.isInteger(page) || page < 1) {
        $("#page").addClass("error");
    }
}

function clearData() {
    $('#dataTable').hide();
    $('#emptyResult').hide();
    $('#search-result').empty();
}

function getDate(milliseconds) {
    console.log(milliseconds);
    return (milliseconds == null) ? "" : new Date(milliseconds).toDateString();
}