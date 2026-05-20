# FP-Sistema 💰📊

O **FP-Sistema** é uma aplicação backend desenvolvida em Java com foco no gerenciamento de finanças pessoais e inteligência financeira. O objetivo principal do sistema é auxiliar o usuário a organizar sua vida financeira e planejar a conquista da sua liberdade financeira através da distribuição automatizada de renda.

---

## 🚀 Funcionalidades Principais (Regras de Negócio)

* **Definição de Perfil Financeiro:** Estruturação da lógica para receber os dados de receita do usuário.
* **Cálculo Automatizado de Orçamento:** Ao processar o salário ou receita, o sistema calcula e distribui automaticamente os valores com base em pilares financeiros essenciais (Regra de base recomendada para saúde financeira).
    * 📌 **Despesas Fixas** (Essenciais)
    * 🎉 **Diversão / Estilo de Vida**
    * 🏦 **Reserva de Emergência / Investimentos**
* **Arquitetura Backend Preparada:** Código estruturado para receber integração com banco de dados relacional (PostgreSQL).

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Linguagem:** Java (Lógica de Programação e Programação Orientada a Objetos)
* **Persistência:** JDBC (Java Database Connectivity)
* **Banco de Dados:** PostgreSQL (Persistência e modelagem de dados relacionais)
* **Arquitetura:** Padrão em Camadas (DAO - Data Access Object e Service) para separação de responsabilidades e organização do código.
* **Ambiente de Desenvolvimento:** VS Code

---

## 🏗️ Arquitetura do Projeto

O projeto foi estruturado seguindo boas práticas de desenvolvimento backend, garantindo que a lógica de negócio fique totalmente isolada das futuras interfaces:

1.  **Model:** Representação das entidades do sistema (Usuário, Finanças, etc.).
2.  **DAO (Data Access Object):** Camada responsável direta pelas instruções SQL e comunicação com o PostgreSQL.
3.  **Service:** Camada onde residem as regras de negócio lógicas (como o cálculo automatizado das porcentagens do orçamento).

---

## 📈 Status do Desenvolvimento

* **Regras de Negócio / Backend:** 🔄 Quase 100% concluído (focado na lógica de distribuição e persistência).
* **Interface com o Usuário:** ⏳ Próxima etapa do cronograma de desenvolvimento.

---

## ✒️ Autor

* **Samuel de Moura Claudino** - [LinkedIn](https://www.linkedin.com/in/samuel-de-moura-claudino-779642101) | [GitHub](https://github.com/samuelclaudino1994-crypto)
