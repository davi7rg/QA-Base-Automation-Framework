# Framework's Base de Automação de Testes
Projeto desenvolvido com a intenção de deter a base dos projetos de automação de testes
- [Web (Front-End)]
- API (Back-End) - *À desenvolver*
- Mobile (Android | iOS) - *À desenvolver*

## Framework Base de Automação Web (Front-End) - JAVA
[Projeto base para utilização na automação de projetos Web (Front-End) - JAVA]

### Começando
Essas instruções fornecerão um entendimento completo do projeto **"Framework Base de Automação Web (Front-End) - JAVA"** bem como do seu uso para desenvolvimento de projetos de automação de testes. 
Consulte "Pré-Requisitos" para obter notas sobre a configuração do ambiente necessário para a devida utilização do framework-base.

### Pré-Requisitos
1. [Java JDK 8 ](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
2. [Eclipse IDE 2020-06 Enterprise Java Developers](https://www.eclipse.org/downloads/packages/release/2020-06/r/eclipse-ide-enterprise-java-developers)
3. [Cucumber]

### Instalando o Cucumber
Após concluído corretamente os passos anteriores, com o Eclipse IDE aberto:
- Selecione no menu superior do Eclipse IDE a opção **Help**
- Selecione a opção **Eclipse Marketplace**
- Na barra de pesquisa, digite o nome **Cucumber** e clique em **Go**
- Você irá visualizar o plugin **Eclipse Cucumber Plugin**, então deverá clicar em **Install**

Após instalado, reinicie o Eclipse IDE e o plugin estará devidamente configurado

### Importando o Framework
Após clonar o projeto da branch master para o seu diretório de preferência:
- Execute o Eclipse IDE
- Selecione a sua workspace (Caso não possua, crie neste momento)
- Com o eclipse aberto na tela inicial:
    - Selecione a opção **"Import"**
    - Procure e expanda a opção **"Maven"**
    - Selecione a opção **"Existing Maven Projects"**
    - Na nova janela que se abrirá, clique em **"Browse"**
    - Selecione a pasta do projeto que contém as pastas "src", "target" e o arquivo "pom.xml" e clique em **"Open"**

Após feito isso, a janela anterior voltará a ser exibida com um arquivo **"pom.xml"** selecionado, então é só concluir a importação clicando em **"Finish"** e o framework-base estará pronto para uso.

### Estrutura do Framework
Este tópico trará informações da estrutura do framework-base para um melhor entendimento do mesmo.

O Framework está representado na seguinte estrutura:

```
▼ java-automation-base-web-framework
  ▼ src/test/java
    ► com.cliente.framework.hooks
    ► com.cliente.framework.pages
    ► com.cliente.framework.runner
    ► com.cliente.framework.steps
    ► com.cliente.framework.utils
  ▼ src/test/resources
    ► chromedriver
    ► evidencias
    ► features
  ► JRE System Library [JavaSE-1.8]
  ► Maven Dependencies
  ▼ target
    ► cucumber-html-report
    pom.xml
```

### Explicando Pacotes
Pacotes contendo as classes **.java** estão contidos no diretório **src/test/java**

► com.cliente.framework.hooks
> Pacote que contém a classe responsável pela configuração da execução dos testes

► com.cliente.framework.pages
> Pacote que contém as classes responsáveis pelo mapeamento dos elementos das páginas bem como a lógica de validação dos testes

► com.cliente.framework.runner
> Pacote que contém a classe responsável por iniciar a execução dos testes

► com.cliente.framework.steps
> Pacote que contém as classes responsáveis pelo passo a passo dos cenários e casos de testes

► com.cliente.framework.utils
> Pacote que contém a classe de métodos gerais a todos os projetos bem e a classe responsável pela geração do relatório de execução

### Explicando Pastas
Pastas que compõem os arquivos necessários para execução e relatório pós-execução.

► chromedriver
> Pasta que contém o drive do navegador chrome necessário para interação automatizada.
> (obs: Caso a pasta não exista, ela deve ser criada.)

► evidencias
> Pasta que contém as evidências de execução dos testes, como prints e relatórios.
> (obs: Caso a pasta não exista, ela deve ser criada.)

► features
> Pasta que contém os arquivos gherkin dos testes.

► target
> Pasta que contém o relatório de log das execuções. O mesmo é criado dentro da pasta **cucumber-html-report**.

► cucumber-html-report
> Pasta que contém os arquivos .html dos logs e execução dos testes.
> (obs: Caso a pasta não exista, ela será criada automaticamente após a primeira execução do framework.)

### Chromedriver
O chromedriver deverá ser baixado e colocado manualmente dentro da pasta **chromedriver**.
> O chromedriver deverá ser baixado de acordo com a versão do seu navegador chrome.

- [Chromedriver - Download](https://chromedriver.chromium.org/downloads)

# Autor
- **Davi Rodrigues** - *Analista de QA Sênior 1*
> [Linkedin](https://www.linkedin.com/in/davi7rg/)







