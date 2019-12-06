import { Component, OnInit } from '@angular/core';
//
import { AngularFirestore } from 'angularfire2/firestore';
import { Observable } from 'rxjs';
import { ConexionService } from '../services/conexion.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  //estudiantes: Observable<any[]>;
  //constructor(db: AngularFirestore) { 
    //this.estudiantes = db.collection('estudiantes').valueChanges();
  //}

  

  estudiantes:any;

  editarItem:any = {
    nombre: '',
    nota1: '',
    nota2: ''
  }

  constructor(private conexion: ConexionService){
    this.estudiantes = this.conexion.listaItem().subscribe(item=>{
      this.estudiantes = item;
      console.log(this.estudiantes);
    })
  }

  ngOnInit() {
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
