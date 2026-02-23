# 📘 Relatório Técnico: Evolução de Arquitetura em Java
> **Implementação de Abstração, Polimorfismo e Interfaces**

Este documento detalha a evolução de um sistema de notificações, partindo de conceitos básicos de POO até uma arquitetura profissional, extensível e baseada em contratos.

---

## 📝 1. Visão Geral do Projeto
O projeto foi desenvolvido como um estudo prático de **Programação Orientada a Objetos (POO)**. O objetivo central foi migrar de um modelo de código acoplado para uma estrutura que respeita o princípio: 
> *"Programar para abstrações, não para implementações."*

### Pilares Aplicados:
* **Abstração e Herança**
* **Sobrescrita (Overriding) e Sobrecarga (Overloading)**
* **Static vs Dynamic Binding**
* **Interfaces como Contratos**
* **Polimorfismo (Upcasting e Downcasting)**

---

## 🏛️ 2. Arquitetura do Sistema

O sistema organiza a comunicação em camadas, simulando o envio de mensagens por múltiplos canais (E-mail e SMS).



### 2.1 Classe Abstrata Base: `Mensagem`
A classe `Mensagem` funciona como o **molde mestre**. Ela é `abstract` pois não existe uma "mensagem genérica" no mundo real; ela serve apenas como base estrutural.

* **Atributo Comum:** `destinatario`
* **Método Abstrato:** `enviar()` (obriga as subclasses a definirem o "como")
* **Método Concreto:** `exibirDados()` (reuso de lógica)
* **Static Binding:** Método `static tipoComunicacao()`

### 2.2 Subclasses Concretas

| Classe | Herança | Interfaces Implementadas | Responsabilidade |
| :--- | :--- | :--- | :--- |
| **MensagemEmail** | `Mensagem` | `Prioritario`, `Agendavel` | Envio de e-mail com suporte a assunto, prioridade e agendamento. |
| **MensagemSMS** | `Mensagem` | `Prioritario` | Envio rápido de texto com nível de urgência. |

---

## 🔬 3. Conceitos Fundamentais Aplicados

### 3.1 Sobrescrita vs. Sobrecarga
1.  **Sobrescrita (Overriding):** Ocorre quando `MensagemEmail` redefine o método `enviar()`. A decisão de qual método chamar é feita em **Runtime (Dynamic Binding)**.
2.  **Sobrecarga (Overloading):** Presente em `MensagemEmail` com `enviar()` e `enviar(String assunto)`. A decisão é feita em **Tempo de Compilação (Static Binding)**.

### 3.2 Static vs Dynamic Binding
No código, a diferença é crucial para a performance e comportamento:

```java
Mensagem minhaMsg = new MensagemEmail("user@email.com");

minhaMsg.tipoComunicacao(); // Static: Chama o método da classe Mensagem (Referência)
minhaMsg.enviar();          // Dynamic: Chama o método da classe MensagemEmail (Objeto Real)

```

## 🏗️ 4. Interfaces como Contratos de Comportamento
A introdução de interfaces permitiu uma expansão horizontal do sistema sem inflar a hierarquia de herança.

- Prioritario: Define uma constante maxNivel = 10 e obriga a implementação de níveis de urgência.

- Agendavel: Introduz o conceito de Default Methods. O método cancelarAgendamento() possui implementação na interface, evitando quebra de contrato em classes antigas.

## 🔁 5. Polimorfismo e Segurança de Tipos
O sistema utiliza o polimorfismo para tratar diferentes objetos de forma uniforme, mas mantém o rigor técnico através de:

- Upcasting: Tratar MensagemEmail como Mensagem para processamento em lote.

- Downcasting Seguro: Uso do operador instanceof antes de realizar conversões de tipo.

```Java
// Exemplo de uso consciente
if (m instanceof Agendavel) {
    ((Agendavel) m).agendar("25/12/2026");
}
```

## 🧠 6. Princípios de Engenharia e Conclusão
A arquitetura final garante Baixo Acoplamento e Alta Coesão. Se um novo canal de comunicação (ex: WhatsApp) for necessário, a estrutura está pronta para recebê-lo sem alterar as classes existentes, respeitando o princípio Open/Closed.

Resultado: Um sistema escalável, onde a complexidade é gerenciada por contratos claros e tipos bem definidos.