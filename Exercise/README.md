# Relatório Técnico: Implementação de Abstração e Polimorfismo em Java

## 📝 Descrição do Projeto
Este projeto foi desenvolvido como um estudo de caso para consolidar conceitos fundamentais da Programação Orientada a Objetos (POO) em Java. O foco principal foi a criação de um sistema de notificações que utiliza **Classes Abstratas**, **Herança**, e demonstra a diferença prática entre **Static** e **Dynamic Binding**.

---

## 🏛️ Arquitetura do Sistema

O sistema é baseado em uma hierarquia de classes que simula o envio de mensagens multiplataforma.

### 1. Superclasse Abstrata: `Mensagem`
A classe `Mensagem` foi definida como `abstract` por ser um conceito genérico. 
- **Objetivo**: Servir como um "molde" para tipos específicos de comunicação.
- **Destaque**: Contém o método abstrato `enviar()`, que define um contrato obrigatório para todas as subclasses.

### 2. Subclasses Concretas: `MensagemEmail` e `MensagemSMS`
Estas classes estendem a classe base e fornecem implementações reais para os métodos.
- **MensagemEmail**: Além de implementar o envio básico, demonstra a **Sobrecarga (Overloading)** ao permitir o envio com ou sem um assunto específico.
- **MensagemSMS**: Implementa a lógica simplificada de envio de mensagens de texto.

---

## 🔬 Conceitos de POO Aplicados

### 1. Abstração e Herança
A abstração permitiu ocultar a complexidade do "como enviar" na classe pai, enquanto a herança permitiu que as subclasses herdassem o atributo `destinatario` e o método `exibirDados()`, promovendo o reuso de código.



### 2. Sobrescrita vs. Sobrecarga
* **Sobrescrita (Overriding)**: O método `enviar()` foi reescrito nas subclasses para realizar tarefas diferentes (E-mail vs SMS).
* **Sobrecarga (Overloading)**: Na classe `MensagemEmail`, criamos múltiplas assinaturas para o método `enviar(String assunto)`, permitindo diferentes formas de uso.

### 3. Ligação Estática e Dinâmica (Binding)
Um dos pontos chave do exercício foi observar como o Java resolve as chamadas de métodos:
* **Static Binding**: Ocorre em métodos `static` (como o `tipoComunicacao()`). O compilador decide qual método chamar baseando-se no **tipo da variável de referência**.
* **Dynamic Binding**: Ocorre em métodos sobrescritos. A decisão é tomada em **tempo de execução (Runtime)**, baseando-se no **tipo real do objeto** instanciado na memória.



---

## 💻 Exemplo de Implementação de Referência Polimórfica

No método `main`, aplicamos o polimorfismo da seguinte forma:

```java
// Referência do tipo Mensagem (Pai), mas objeto do tipo MensagemEmail (Filho)
Mensagem minhaMsg = new MensagemEmail("usuario@provedor.com");

minhaMsg.tipoComunicacao(); // Executa o método da classe Mensagem (Static Binding)
minhaMsg.enviar();          // Executa o método da classe MensagemEmail (Dynamic Binding)