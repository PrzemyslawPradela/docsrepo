<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj dokument</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.4.1/sketchy/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" />
    </head>
    <body>
        <header></header>
        <div class="container mt-5 mb-5" style="width: 45%">
            <form action="UploadServlet" enctype="multipart/form-data" method="post">
                <fieldset>
                    <div class="form-group">
                        <label for="inputName">Nazwa dokumentu</label>
                        <input type="text" class="form-control" id="inputName" name="name" aria-describedby="nameHelp" placeholder="Wpisz nazwę dokumentu">
                        <small id="nameHelp" class="form-text text-muted">Maksymalna długość nazwy dokumentu to 512 znaków</small>
                    </div>
                    <div class="form-group">
                        <label for="contentDesTextarea">Opis zawartości dokumentu</label>
                        <textarea class="form-control" id="contentDesTextarea" name="contentDescription" rows="10" aria-describedby="contentDesHelp"></textarea>
                        <small id="contentDesHelp" class="form-text text-muted">Maksymalna długość opisu zawartości dokumentu to 2048 znaków</small>
                    </div>
                    <div class="form-group">
                        <label for="inputFile"><i class="fas fa-file-word fa-2x"></i> Wybierz plik</label>
                        <input type="file" accept="application/msword" class="form-control-file" id="inputFile" name="file" aria-describedby="fileHelp">
                        <small id="fileHelp" class="form-text text-muted">Akceptowane są pliki z rozszerzeniem *.doc</small>
                    </div>
                    <button type="submit" class="btn btn-primary" id="submit" disabled><i class="fas fa-file-upload fa-lg"></i> Dodaj</button>
                </fieldset>
            </form>
        </div>
        <script>
            fetch("./header.html")
                    .then(response => {
                        return response.text();
                    })
                    .then(data => {
                        document.querySelector("header").innerHTML = data;
                    });

            $(document).ready(function () {
                $('.form-group input').bind('keyup change', function () {
                    let empty = false;

                    $('.form-group input').each(function () {
                        empty = $(this).val().length === 0;
                    });

                    if (empty)
                        $('#submit').attr('disabled', true);
                    else
                        $('#submit').attr('disabled', false);
                });
            });
        </script>
    </body>
</html>
