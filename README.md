#  Média Geral - Sistema de Gerenciamento de Notas

Aplicação Android desenvolvida em **Kotlin** utilizando **Jetpack Compose** e arquitetura **MVC** para gerenciar notas de alunos e calcular médias.

##  Sobre o Projeto

Este projeto foi desenvolvido como atividade acadêmica e tem como objetivo criar um sistema que permite:

- Cadastrar alunos com nome completo e três notas parciais (TP1, TP2, TP3)
- Calcular automaticamente a média aritmética das notas
- Avaliar o desempenho do aluno conforme critérios estabelecidos
- Exibir visualmente o status final de cada aluno

##  Funcionalidades

### Cadastro de Aluno
- Inserir nome completo do aluno
- Lançar três notas parciais (TP1, TP2, TP3)
- Validação automática dos campos obrigatórios
- Botão de cadastro habilitado apenas quando todos os campos estão preenchidos

### Cálculo Automático
- Média aritmética calculada automaticamente: `(TP1 + TP2 + TP3) / 3`
- Atualização em tempo real ao adicionar novo aluno

### Avaliação de Desempenho
O sistema classifica o aluno baseado na média:

| Média | Status | Cor |
|-------|--------|-----|
| < 6.0 | 🔴 Reprovado | Vermelho |
| 6.0 - 9.0 | 🟢 Aprovado | Verde |
| > 9.0 | 🔵 Ótimo Aproveitamento | Azul |

### Interface Visual
- Cards coloridos para cada aluno conforme o status
- Lista responsiva com scroll
- Design Material 3
- Feedback visual intuitivo

## Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)**:

```
app/src/main/java/com/example/media_geral_kt/
├── model/
│   └── Aluno.kt                    # Modelo de dados
├── viewmodel/
│   └── AlunoViewModel.kt           # Gerenciamento de estado
├── view/
│   └── AlunoScreen.kt              # Interface do usuário
└── MainActivity.kt                 # Controller principal
```

### Model
**`Aluno.kt`** - Data class que representa um aluno:
- Propriedades: `nomeCompleto`, `tp1`, `tp2`, `tp3`
- Computed properties: `mediaGeral`, `statusFinal`
- Lógica de negócio para cálculo e avaliação

### ViewModel
**`AlunoViewModel.kt`** - Gerencia o estado da aplicação:
- Lista reativa de alunos usando `mutableStateOf`
- Campos do formulário com binding
- Função `adicionarAluno()` para processar cadastros
- Limpeza automática dos campos após cadastro

### View
**`AlunoScreen.kt`** - Interface Jetpack Compose:
- `AlunoScreen`: Tela principal com Scaffold
- `CadastroSection`: Formulário de cadastro
- `ListaAlunos`: Lista de alunos cadastrados
- `AlunoCard`: Card individual para cada aluno

## Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **UI Framework:** Jetpack Compose
- **Arquitetura:** MVC (Model-View-Controller)
- **Estado:** Compose State Management
- **ViewModel:** Lifecycle ViewModel Compose
- **Material Design:** Material 3
- **Build Tool:** Gradle (Kotlin DSL)

## Dependências

```kotlin
implementation("androidx.core:core-ktx")
implementation("androidx.lifecycle:lifecycle-runtime-ktx")
implementation("androidx.activity:activity-compose")
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
```

## Como Executar

### Pré-requisitos
- Android Studio (versão recomendada: Hedgehog ou superior)
- JDK 11 ou superior
- Android SDK (API 24+)
- Emulador Android ou dispositivo físico

### Passos

1. **Clone o repositório:**
```bash
git clone https://github.com/jaobarreto/media-geral-kt.git
cd media-geral-kt
```

2. **Abra o projeto no Android Studio:**
   - `File` → `Open` → Selecione a pasta do projeto

3. **Sincronize o Gradle:**
   - Clique em `Sync Now` quando aparecer a notificação
   - Ou: `File` → `Sync Project with Gradle Files`

4. **Build o projeto:**
   - `Build` → `Clean Project`
   - `Build` → `Make Project` (Ctrl+F9)

5. **Execute o app:**
   - Conecte um dispositivo ou inicie um emulador
   - Clique em ▶️ Run (Shift+F10)

## Exemplos de Uso

```kotlin
// Exemplo de dados de entrada:
Nome: João Barreto
TP1: 8.0
TP2: 7.5
TP3: 9.0
// Resultado: Média 8.17 - Status: Aprovado ✅

Nome: Kamille Gomes
TP1: 9.5
TP2: 10.0
TP3: 9.8
// Resultado: Média 9.77 - Status: Ótimo Aproveitamento 🌟

Nome: Ravi Barreto
TP1: 5.0
TP2: 4.5
TP3: 5.5
// Resultado: Média 5.00 - Status: Reprovado ❌
```

## Estrutura do Projeto

```
mediageralkt/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/media_geral_kt/
│   │   │   │   ├── model/
│   │   │   │   │   └── Aluno.kt
│   │   │   │   ├── viewmodel/
│   │   │   │   │   └── AlunoViewModel.kt
│   │   │   │   ├── view/
│   │   │   │   │   └── AlunoScreen.kt
│   │   │   │   ├── ui/theme/
│   │   │   │   │   ├── Color.kt
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   └── Type.kt
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Autor

**João Barreto**
- GitHub: [@jaobarreto](https://github.com/jaobarreto)

## Licença

Este projeto foi desenvolvido para fins educacionais.