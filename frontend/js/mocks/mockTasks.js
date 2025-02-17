import Task from '../entities/Task.js'

let mockTasks = [
    new Task(
        'Reunião de Planejamento',
        'Definir metas para o próximo trimestre',
        'Trabalho',
        4,
        1,
        new Date('2024-05-20'),
        new Date('2024-05-25'),
        null
    ),

    new Task(
        'Estudar TypeScript',
        'Completar módulo avançado de tipos',
        'Estudos',
        5,
        2,
        new Date('2024-05-15'),
        new Date('2024-05-22'),
        new Date('2024-05-28')
    ),

    new Task(
        'Malhar na Academia',
        'Treino de pernas e cardio',
        'Saúde',
        3,
        0,
        new Date('2024-05-15'),
        null,
        null
    ),

    new Task(
        'Atualizar Portfólio',
        'Adicionar projetos recentes e melhorar layout',
        'Carreira',
        4,
        1,
        new Date('2024-05-18'),
        new Date(),
        null
    ),

    new Task(
        'Ler Atomic Habits',
        'Capítulos 5-8',
        'Desenvolvimento Pessoal',
        2,
        2,
        new Date('2024-05-10'),
        new Date('2024-05-17'),
        new Date('2024-05-25')
    ),

    new Task(
        'Organizar Garage',
        'Descarte de objetos e limpeza geral',
        'Casa',
        3,
        0,
        new Date(),
        null,
        null
    ),

    new Task(
        'Configurar CI/CD',
        'Implementar pipeline de deploy automático',
        'Tecnologia',
        5,
        1,
        new Date('2024-05-22'),
        new Date('2024-05-27'),
        null
    ),

    new Task(
        'Consulta Médica',
        'Check-up anual',
        'Saúde',
        5,
        2,
        new Date('2024-05-05'),
        new Date('2024-05-05'),
        new Date('2024-05-12')
    ),

    new Task(
        'Escrever Artigo Técnico',
        'Sobre padrões de design em React',
        'Escrita',
        3,
        0,
        new Date(),
        null,
        null
    ),

    new Task(
        'Atualizar Dependências',
        'Node.js para versão 20 e pacotes npm',
        'Desenvolvimento',
        4,
        2,
        new Date('2024-05-01'),
        new Date('2024-05-15'),
        new Date('2024-05-20')
    ),
]

export default mockTasks
