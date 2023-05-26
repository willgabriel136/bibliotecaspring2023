<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Novo Livro</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
    <h1>Remover Livro</h1>
    <p>Tem certeza que deseja remover o livro ${livro.titulo}</p>
    <form action="/livro/delete" method="post">
        <input type="hidden" name="id"  value="${livro.id}"/>
        </div>
        <br />
        <a href="/livro/list" class="btn btn-primary">Voltar</a>
        <button type="submit" class="btn btn-success">Salvar</button>
    </form>
</div>
</body>
</html>