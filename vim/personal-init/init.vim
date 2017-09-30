let g:jedi#goto_comand = "<leader>d"
let g:jedi#goto_assignments_command = "<leader>g"
let g:jedi#goto_definitions_command = ""
let g:jedi#documentation_command = "K"
let g:jedi#usages_command = "<leader>n"
let g:jedi#completions_command = "<C-Space>"
let g:jedi#rename_command = "<leader>r"

" Starting vim-plug https://github.com/junegunn/vim-plug
" After add a plugin you should reload this file and run :PlugInstall
call plug#begin('~/.local/share/nvim/plugged')

" MarkDown plugin
Plug 'godlygeek/tabular'
Plug 'plasticboy/vim-markdown'

" Python Completion Plugin
Plug 'davidhalter/jedi-vim'

" Java Completion Plugin
Plug 'artur-shaik/vim-javacomplete2'


call plug#end()
