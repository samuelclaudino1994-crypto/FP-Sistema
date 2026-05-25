# 💰 FP Finanças

Sistema de gerenciamento financeiro pessoal desenvolvido em Java com foco em inteligência financeira preventiva, organização orçamentária e arquitetura desacoplada.

O projeto foi concebido aplicando conceitos de engenharia de software, separação em camadas, persistência em nuvem e regras automatizadas de saúde financeira.

---

# 🚀 Objetivo do Projeto

O FP Finanças não atua apenas como um histórico de gastos tradicional.

A proposta do sistema é auxiliar o usuário na tomada de decisões financeiras através de:

- distribuição automatizada de orçamento;
- monitoramento preventivo de gastos;
- alertas financeiros inteligentes;
- organização patrimonial;
- metas de economia.

---

# 🧠 Diferencial do Sistema

O núcleo do projeto utiliza uma lógica automatizada baseada no método financeiro:

```text
55% → Gastos Essenciais
25% → Estilo de Vida / Lazer
20% → Reserva Financeira
```

O sistema monitora continuamente os gastos do usuário e dispara alertas preventivos quando os limites começam a ser atingidos.

Exemplo:

```text
⚠ Atenção: Você atingiu 80% do limite da categoria “Lazer”.
```

---

# 🛠️ Stack Tecnológica

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 25 |
| Build Tool | Maven |
| Banco de Dados | PostgreSQL |
| Backend Cloud | Supabase |
| Persistência | JDBC |
| Testes | JUnit 5 |
| Versionamento | Git/GitHub |
| Interface | JavaFX (planejado) |

---

# 🏗️ Arquitetura do Projeto

O sistema foi estruturado seguindo arquitetura desacoplada em camadas:

```text
[ View / Controller ]
          ↓
[ Service ]
          ↓
[ DAO / Repository ]
          ↓
[ PostgreSQL / Supabase ]
```

---

# 📂 Estrutura do Projeto

```text
FP-Financas/
├── docs/
├── src/
│   ├── model/
│   ├── service/
│   ├── repository/
│   ├── controller/
│   ├── view/
│   └── util/
├── tests/
├── pom.xml
├── README.md
└── .gitignore
```

---

# 📌 Funcionalidades Implementadas

## ✅ Core Financeiro

- Cadastro de usuários
- Controle de categorias
- Registro de receitas e despesas
- Cálculo automático de orçamento
- Consolidação de saldo
- Regras de divisão financeira
- Persistência integrada ao banco
- Blindagem de entradas

---

# 🔐 Segurança e Validação

O projeto implementa:

- validação de entradas;
- encapsulamento;
- proteção contra valores inválidos;
- arquitetura desacoplada;
- persistência segura;
- Row-Level Security (RLS);
- criptografia de senhas (planejado).

---

# 🧪 Testes Automatizados

As regras críticas da aplicação são validadas utilizando:

```text
JUnit 5
```

Os testes garantem:
- integridade dos cálculos financeiros;
- estabilidade das regras de negócio;
- segurança em futuras refatorações.

---

# ▶️ Como Executar o Projeto

## 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/fp-financas.git
```

---

## 2️⃣ Acesse a pasta do projeto

```bash
cd FP-Financas
```

---

## 3️⃣ Compile utilizando Maven

```bash
mvn clean install
```

---

## 4️⃣ Execute os testes

```bash
mvn test
```

---

# 📚 Documentação Técnica

A documentação detalhada do projeto está disponível na pasta:

```text
/docs
```

Incluindo:
- arquitetura;
- requisitos funcionais;
- regras de negócio;
- modelagem;
- evolução técnica.

---

# 📈 Status do Projeto

| Etapa | Status |
|---|---|
| Core Financeiro | ✅ Em desenvolvimento |
| Persistência Supabase | ✅ Implementado |
| Regras Financeiras | ✅ Implementadas |
| Testes Automatizados | ✅ Parcial |
| Interface Desktop | ⏳ Próxima etapa |
| Migração Web | 🔮 Futuro |

---

# 👨‍💻 Autor

Samuel de Moura Claudino

## 🔗 Links

- GitHub:
  https://github.com/samuelclaudino1994-crypto

- LinkedIn:
  https://www.linkedin.com/in/samuel-de-moura-claudino-779642101

---

# 📜 Licença

Projeto desenvolvido para fins educacionais, evolução técnica e portfólio profissional.