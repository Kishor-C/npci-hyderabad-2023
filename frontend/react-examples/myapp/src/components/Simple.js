
export function Greetings() {
    return (<div>
        <h2>Greetings component</h2>
    </div>)
}
// props is used to share the data from one component to another component
// <Hello username = 'Alex' age = '30' />
export function Hello(props) {
    // props = {username = value, age = value}
    // username & age will be undefined if props is not sent
    let user = props.username; 
    let age = props.age;
    //return (<div>Hello {user}, your age is: {age}</div>);
    return (<div>
        {user != undefined ? <div>Hello {user}</div> : <div>Hello Guest</div>}
    </div>)
}