import { Component, OnInit } from '@angular/core';

import {UsuariosService} from './usuarios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  //title = 'calificaciones';
  usuarios = null;

  usuario = {
    idUsuario: null,
    nombre: null,
    telefono: null,
    email: null

  }

  constructor(private UsuariosServicio: UsuariosService){}

  ngOnInit() {
    this.obtenerUsuarios();
  }

  obtenerUsuarios(){
    this.UsuariosServicio.obtenerUsuarios().subscribe(
      result => this.usuarios=result
    );
  }
  altaUsuario(){
    this.UsuariosServicio.altaUsuarios(this.usuario).subscribe(
      datos => {
        if(datos ['resultado']=='OK'){
          alert(datos['mensaje']);
          this.obtenerUsuarios();
        }
      }
    );
  }
  bajaUsuario(idUsuario){
    this.UsuariosServicio.bajaUsuarios(idUsuario).subscribe(
      datos => {
        if(datos ['resultado']=='OK'){
          alert(datos['mensaje']);
          this.obtenerUsuarios();
        }
      }
    );
  }

  editaUsuario(){
    this.UsuariosServicio.editarUsuario(this.usuario).subscribe(
      datos => {
        if(datos ['resultado']=='OK'){
          alert(datos['mensaje']);
          this.obtenerUsuarios();
        }
      }
    )
  }

  seleccionarUsuario(idUsuario){
    this.UsuariosServicio.seleccionarUsuario(idUsuario).subscribe(
      result => this.usuario = result[0]
    );
  }

hayRegistros(){
  return true;
  }
}


