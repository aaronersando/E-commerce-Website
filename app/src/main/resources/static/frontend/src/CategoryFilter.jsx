
function CategoryFilter({categories, OnSelect}){

    return(
        <>
        <select onChange={(e) => OnSelect(e.target.value)} className="form-control" id="categorySelect">
            <option value="">All Categories</option>
            {categories.map((category) => (
                <option key={category.id} value={category.id}>{category.name}</option>
            ))}
        </select>
        </>
    )
}

export default CategoryFilter;