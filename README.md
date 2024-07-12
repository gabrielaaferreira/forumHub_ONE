Terceiro e último desafio do programa ONE

Esse se aprentou mais complexo, devido ao módulo Security.
A aplicação permite criação de tópicos apenas por usuários cadastrados e o armazenamento no banco de dados.
Há espaço para melhoramento, especialmente em detalhes de usuários.

Deve-se criar primeiro um usuário no banco de dados com id, login e senha criptografada em BCrypt.


Para configurar localmente é necessário configurar o banco de dados, como no exemplo abaixo:
spring.datasource.url=jdbc:mysql://localhost:3306/apiforumhub
spring.datasource.username=root
spring.datasource.password=123

