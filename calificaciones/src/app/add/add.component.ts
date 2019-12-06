import { Component, OnInit } from '@angular/core';
//

import { Router } from '@angular/router';
import { ConexionService } from 'src/app/services/conexion.service';



@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  item:any = {
    nombre:'',
    nota1:'',
    nota2:'',
    total: ''
  }

  constructor(private servicio:ConexionService) { }

  ngOnInit() {
  }

    val1:number;
    val2:number;
    total:number;
  
  agregar(){
    this.servicio.agregarItem(this.item);
    this.item.nombre='';
    this.item.nota1='';
    this.item.nota2='';
    this.item.total=this.val1+this.val2;

    console.log("resultado:  "+ this.val1);
  }

}
