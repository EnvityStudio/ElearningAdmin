$(".btn-delete-user").click(function () {
    var iduser = $(this).data("id");
    var r = confirm("Are you sure delete this user?");
    if (r == true) {
        $.delete("/ElearningAdmin/user/delete",
                {
                    iduser: iduser
                },
                function (data, status, xhr) {
                    window.location.reload()
                });
    } else {
    }
});

