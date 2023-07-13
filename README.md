# candidates-apiRest
# README - Candidatos Backend
Este é o projeto de backend para o sistema de gerenciamento de candidatos. Ele foi desenvolvido utilizando o framework Spring Boot e possui uma API RESTful para realizar operações relacionadas aos candidatos.

# Requisitos
Antes de executar o projeto, verifique se você possui os seguintes requisitos instalados em sua máquina:

Java Development Kit (JDK) 17 ou superior
Maven

# Executando o projeto
Siga as instruções abaixo para executar o projeto de backend:

Faça o clone deste repositório para o seu ambiente local.
Abra o terminal e navegue até o diretório raiz do projeto.

# Comando Maven
Execute o seguinte comando para compilar e executar o projeto:
bash
Copy code
mvn spring-boot:run
Isso irá baixar as dependências do projeto, compilar o código e iniciar o servidor de aplicação embutido do Spring Boot.

# Acesso à API
Após iniciar o projeto, a API estará acessível no seguinte endpoint:

http://localhost:8080/api/v1/hiring


# Documentação da API
A API possui os seguintes endpoints:

GET /api/v1/hiring: Retorna a lista de todos os candidatos cadastrados.
POST /api/v1/hiring: Cria um novo candidato.
POST /api/v1/hiring/start: Inicia o processo de contratação para um candidato.
POST /api/v1/hiring/schedule: Agenda uma entrevista para um candidato qualificado.
POST /api/v1/hiring/disqualify: Desqualifica um candidato e o remove do sistema.
POST /api/v1/hiring/approve: Aprova um candidato.
GET /api/v1/hiring/status/candidate/{codCandidato}: Retorna o status de um candidato específico.
GET /api/v1/hiring/approved: Retorna a lista de candidatos aprovados.
Os dados devem ser enviados no formato JSON no corpo da requisição.

# Configuração do CORS

O projeto já possui uma configuração pré-definida para permitir o acesso de origens diferentes. No entanto, por padrão, está configurado para permitir apenas o acesso da origem http://localhost:3000. Se necessário, você pode modificar a configuração do CORS no arquivo CorsConfig.java para permitir outras origens.

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
Certifique-se de atualizar as origens permitidas de acordo com suas necessidades.

# Banco de dados
O projeto utiliza o banco de dados H2 em memória. Não é necessário nenhuma configuração adicional, pois o Spring Boot já possui suporte integrado para o H2. No entanto, os dados serão perdidos após o término da execução do projeto.

# Frontend
Este projeto de backend foi desenvolvido para ser utilizado em conjunto com um frontend. Certifique-se de ter o projeto de frontend configurado e em execução para interagir adequadamente com o backend. E pode ser acessado pelo repositório no caminho https://github.com/DeAT1995/candidates . 

# Conclusão
O projeto de backend está configurado corretamente para ser executado e utilizado em conjunto com o frontend. Siga as instruções fornecidas para iniciar o projeto e aproveite as funcionalidades do sistema de gerenciamento de candidatos.
