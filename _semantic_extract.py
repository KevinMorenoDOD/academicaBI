if __name__ == '__main__':
    import json
    from graphify.semantic import semantic_extract
    from pathlib import Path

    ast_data = json.loads(Path('graphify-out/.graphify_ast.json').read_text(encoding='utf-8'))
    result = semantic_extract(ast_data, cache_root=Path('.'))
    Path('graphify-out/.graphify_semantic.json').write_text(json.dumps(result, indent=2, ensure_ascii=False), encoding='utf-8')
    print(f'Semantic: {len(result.get("nodes",[]))} nodes, {len(result.get("edges",[]))} edges')
