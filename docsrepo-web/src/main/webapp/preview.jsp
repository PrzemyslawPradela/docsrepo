<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Podgląd dokumentu</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.4.1/sketchy/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" />
        <link rel="icon" href="images/logo.png">
    </head>
    <body>
        <header></header>
        <div class="container mt-5 mb-5" style="width: 45%">
            <form action="PreviewServlet" enctype="multipart/form-data" method="post">
                <fieldset>
                    <input name="id" value="${document.id}" style="display: none"/>
                    <div class="form-group">
                        <label for="inputName">Nazwa dokumentu</label>
                        <input type="text" class="form-control" id="inputName" name="name" aria-describedby="nameHelp" placeholder="Wpisz nazwę dokumentu" value="${document.name}">
                        <small id="nameHelp" class="form-text text-muted">Maksymalna długość nazwy dokumentu to 512 znaków</small>
                    </div>
                    <div class="form-group">
                        <label for="contentDesTextarea">Opis zawartości dokumentu</label>
                        <textarea class="form-control" id="contentDesTextarea" name="contentDescription" rows="10" aria-describedby="contentDesHelp">${document.contentDescription}</textarea>
                        <small id="contentDesHelp" class="form-text text-muted">Maksymalna długość opisu zawartości dokumentu to 2048 znaków</small>
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-switch">
                            <input type="checkbox" class="custom-control-input" id="customSwitch" onclick="isChecked()">
                            <label class="custom-control-label" for="customSwitch">Zmień plik dokumentu</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFile"><i class="fas fa-file-word fa-2x"></i> Wybierz plik</label>
                        <input type="file" accept="application/msword" class="form-control-file" id="inputFile" name="file" aria-describedby="fileHelp" disabled>
                        <small id="fileHelp" class="form-text text-muted">Akceptowane są pliki z rozszerzeniem *.doc</small>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary" id="submit" style="margin-right: 33%">
                            <i class="fas fa-check fa-lg"></i> Zatwierdź
                        </button>
                        <a class="btn btn-primary text-light" href="DownloadServlet?id=${document.id}&name=${document.name}">
                            <i class="fas fa-file-download fa-lg"></i> Pobierz dokument
                        </a>
                        <a class="btn btn-primary text-light" href="DeleteServlet?id=${document.id}" style="float: right">
                            <i class="fas fa-trash-alt fa-lg"></i> Usuń
                        </a>
                    </div>
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

            function isChecked() {
                if (document.getElementById('customSwitch').checked) {
                    document.getElementById('inputFile').disabled = false;
                } else {
                    document.getElementById('inputFile').disabled = true;
                }
            }
        </script>
    </body>
</html>
