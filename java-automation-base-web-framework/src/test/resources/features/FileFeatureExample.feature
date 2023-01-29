#language:pt

#Author: Davi Rodrigues - Analista de QA Senior 1

#Funcionalidade: Lista dos Cenários de Teste
#Cenario: Regra de negocio contendo o passo a passo do cenario de teste
#Dado: Precondicao do passo a passo
#Quando: Se executa alguma acao
#Entao: Um comportamento de validacao e obervado
#E: Exista mais um passo a ser realizado antes de um "Dado", "Quando" ou "Entao"
#Esquema do Cenario: Lista de passos a serem realizados repetidamente, porem com informacoes distintas
#Exemplos: Contem as informacoes que sao passadas via variaveis no "Esquema de Cenario"
#Contexto: Lista de etapas executadas antes de cada um dos cenarios

#Utilizar todas as palavras sem acentuacao

@Funcionalidade
Funcionalidade: Titulo da Funcionalidade
  Descricao do que se espera com a devida execucao da funcionalidade

	Contexto:
		Dado que eu faca alguma coisa como premissa de todos os cenarios

  @Cenario1
  Cenario: Titulo do Cenario
    E essa condicao e atendida
    Quando executo alguma acao
    Entao o resultado esperado me e mostrado

  @Cenario2
  Esquema do Cenario: Titulo do Cenario
    Dado que informo a precondicao com a <funcao>
    Quando checo a condicao com o <valor> nesse passo
    Entao verifico que o resultado esta <status>

    Exemplos: 
      | funcao  | valor | status	 	|
      | dev 		|		5 	| positivo	|
      | qa	 		|   7 	| falho   	|