import { Component, OnInit } from '@angular/core';
//
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';
//
import { AngularFirestore } from 'angularfire2/firestore';
import { Observable } from 'rxjs';
import { ConexionService } from '../services/conexion.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: firebase.User;


  estudiantes:any;

  editarItem:any = {
    nombre: '',
    nota1: '',
    nota2: ''
  }

  constructor(
    private auth: AuthService, 
    private router: Router,
    private conexion: ConexionService
  ) { 
    this.estudiantes = this.conexion.listaItem().subscribe(item=>{
      this.estudiantes = item;
      console.log(this.estudiantes);
    })
  }

  ngOnInit() {
    this.auth.getUserState()
      .subscribe( user => {
        this.user = user;
      })
  }

  login() {
    this.router.navigate(['/login']);
  }

  logout() {
    this.auth.logout();
  }

  register() {
    this.router.navigate(['/register']);
  }

  eliminar(item){
    this.conexion.eliminarItem(item);
  }

  editar(item){
    this.editarItem = item;
  }

  agregarItemEditado(){
    this.conexion.editarItem(this.editarItem);
  }
  
  
}
