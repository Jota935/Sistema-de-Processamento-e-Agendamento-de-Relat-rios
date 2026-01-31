
Objetivos

* Automatizar o processamento de relatórios
* Aplicar conceitos de **programação concorrente em Java**
* Garantir isolamento de dados entre threads
* Implementar tratamento centralizado de exceções

---
Conceitos de Programação Concorrente Utilizados

ThreadLocal

Permite que cada thread mantenha suas próprias configurações (ex.: UserID), evitando interferência entre utilizadores.

Timer e TimerTask

Utilizados para agendar a geração automática de relatórios a cada **5 segundos**.

UncaughtExceptionHandler

Captura exceções não tratadas em threads de forma centralizada, permitindo registo e diagnóstico de erros.

---

Estrutura do Projeto

```
├── Main.java
├── Relatorio.java
├── ProcessadorDeRelatorios.java
├── RelatorioTimer.java
└── GlobalExceptionHandler.java
```

---
Descrição das Classes

 Relatorio

Representa um relatório processado por um utilizador.

**Atributos:**

* `userId` – Identificador do utilizador
* `timestamp` – Momento da geração do relatório
* `conteudo` – Conteúdo textual do relatório

---

ProcessadorDeRelatorios

Implementa a lógica de processamento do relatório.

* Usa `ThreadLocal` para manter o `UserID` específico de cada thread
* Gera exceção caso o `UserID` não esteja configurado

---

RelatorioTimer

Responsável pelo agendamento da geração de relatórios.

* Dispara uma nova thread a cada **5 segundos**
* Simula múltiplos utilizadores
* Após **20 segundos**, encerra o agendamento
* Força uma exceção para demonstrar o funcionamento do handler global

---

 GlobalExceptionHandler

Define um handler global para capturar exceções não tratadas.

* Usa `Thread.setDefaultUncaughtExceptionHandler`
* Regista mensagens de erro no console

---

Main

Classe principal do sistema.

* Inicializa o handler global de exceções
* Inicia o agendador de relatórios

---

Execução do Projeto

1. Compile todas as classes Java
2. Execute a classe `Main`

```bash
javac *.java
java Main
```

---

 Exemplo de Saída no Console

```
Relatório processado: Relatório [UserID: 1, Timestamp: 1698787320000, Conteúdo: Conteúdo do relatório das propinas]
Relatório processado: Relatório [UserID: 2, Timestamp: 1698787325000, Conteúdo: Conteúdo do relatório das matrículas]
Exceção capturada no thread Thread-3: UserID não configurado para o thread atual.
Agendamento de relatórios encerrado.
```



Conclusão

Este projeto demonstra de forma prática a aplicação de **Programação Concorrente em Java**, destacando o uso de threads, isolamento de dados com `ThreadLocal`, agendamento de tarefas e tratamento centralizado de exceções. A solução proposta reduz o processamento manual e aumenta a eficiência e robustez do sistema de relatórios da Universidade de Mindelo.


