
const AgregarTarea = ({tarea, setTarea})=>{
    
    const handleChange = (e) => {
        setTarea({
            ...tarea,
            [e.target.name]: e.target.value
        })
    }

    let{descripcion, fechaCreacion, vigente} = tarea

    const handleSubmit = (e) => {

        const request = {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(tarea)
        }

        fetch("http://localhost:8088/tareas", request)
        .then(res => res.text())
        .then(res=> console.log(res))

        setTarea({
            id:0,
            descripcion:"",
            fechaCreacion:"",
            vigente:1
          })
    }
    return(
        <div className="container">
            <form onSubmit={handleSubmit}>
            <div className="form-group">
                <label>
                Descripcion:
                <input type="text" onChange={handleChange} name="descripcion" className="form-control" required />
                </label>
            </div>
            <div className="form-group">
            <label>
            Fecha:
            <input type="date" onChange={handleChange}  name="fechaCreacion" className="form-control" required />
            </label>
            </div>
            <div className="form-group">
            <label>
            Vigencia:
            <select value={tarea.vigente} onChange={handleChange} name="vigente" className="form-control" required >
                <option value="true">SI</option>
                <option value="false">NO</option>
            </select>
            </label>
            </div>
            <input type="submit" value="Agregar" className="btn btn-primary" />
        </form>
        </div>
    )

}



export default AgregarTarea